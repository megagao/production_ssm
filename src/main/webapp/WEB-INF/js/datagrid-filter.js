(function($){
	function getPluginName(target){
		if ($(target).data('treegrid')){
			return 'treegrid';
		} else {
			return 'datagrid';
		}
	}

	var autoSizeColumn1 = $.fn.datagrid.methods.autoSizeColumn;
	var loadDataMethod1 = $.fn.datagrid.methods.loadData;
	var appendMethod1 = $.fn.datagrid.methods.appendRow;
	var deleteMethod1 = $.fn.datagrid.methods.deleteRow;
	$.extend($.fn.datagrid.methods, {
		autoSizeColumn: function(jq, field){
			return jq.each(function(){
				var fc = $(this).datagrid('getPanel').find('.datagrid-header .datagrid-filter-c');
				// fc.hide();
				fc.css({
					width:'1px',
					height:0
				});
				autoSizeColumn1.call($.fn.datagrid.methods, $(this), field);
				// fc.show();
				fc.css({
					width:'',
					height:''
				});
				resizeFilter(this, field);
			});
		},
		loadData: function(jq, data){
			jq.each(function(){
				$.data(this, 'datagrid').filterSource = null;
			});
			return loadDataMethod1.call($.fn.datagrid.methods, jq, data);
		},
		appendRow: function(jq, row){
			var result = appendMethod1.call($.fn.datagrid.methods, jq, row);
			jq.each(function(){
				var state = $(this).data('datagrid');
				if (state.filterSource){
					state.filterSource.total++;
					if (state.filterSource.rows != state.data.rows){
						state.filterSource.rows.push(row);
					}
				}
			});
			return result;
		},
		deleteRow: function(jq, index){
			jq.each(function(){
				var state = $(this).data('datagrid');
				var opts = state.options;
				if (state.filterSource && opts.idField){
					if (state.filterSource.rows == state.data.rows){
						state.filterSource.total--;
					} else {
						for(var i=0; i<state.filterSource.rows.length; i++){
							var row = state.filterSource.rows[i];
							if (row[opts.idField] == state.data.rows[index][opts.idField]){
								state.filterSource.rows.splice(i,1);
								state.filterSource.total--;
								break;
							}
						}
					}
				}
			});
			return deleteMethod1.call($.fn.datagrid.methods, jq, index);		
		}
	});

	var loadDataMethod2 = $.fn.treegrid.methods.loadData;
	var appendMethod2 = $.fn.treegrid.methods.append;
	var insertMethod2 = $.fn.treegrid.methods.insert;
	var removeMethod2 = $.fn.treegrid.methods.remove;
	$.extend($.fn.treegrid.methods, {
		loadData: function(jq, data){
			jq.each(function(){
				$.data(this, 'treegrid').filterSource = null;
			});
			return loadDataMethod2.call($.fn.treegrid.methods, jq, data);
		},
		append: function(jq, param){
			return jq.each(function(){
				var state = $(this).data('treegrid');
				var opts = state.options;
				if (opts.oldLoadFilter){
					var rows = translateTreeData(this, param.data, param.parent);
					state.filterSource.total += rows.length;
					state.filterSource.rows = state.filterSource.rows.concat(rows);
					$(this).treegrid('loadData', state.filterSource)
				} else {
					appendMethod2($(this), param);
				}
			});
		},
		insert: function(jq, param){
			return jq.each(function(){
				var state = $(this).data('treegrid');
				var opts = state.options;
				if (opts.oldLoadFilter){
					var ref = param.before || param.after;
					var index = getNodeIndex(param.before || param.after);
					var pid = index>=0 ? state.filterSource.rows[index]._parentId : null;
					var rows = translateTreeData(this, [param.data], pid);
					var newRows = state.filterSource.rows.splice(0, index>=0 ? (param.before ? index : index+1) : (state.filterSource.rows.length));
					newRows = newRows.concat(rows);
					newRows = newRows.concat(state.filterSource.rows);
					state.filterSource.total += rows.length;
					state.filterSource.rows = newRows;
					$(this).treegrid('loadData', state.filterSource);

					function getNodeIndex(id){
						var rows = state.filterSource.rows;
						for(var i=0; i<rows.length; i++){
							if (rows[i][opts.idField] == id){
								return i;
							}
						}
						return -1;
					}
				} else {
					insertMethod2($(this), param);
				}
			});
		},
		remove: function(jq, id){
			jq.each(function(){
				var state = $(this).data('treegrid');
				if (state.filterSource){
					var opts = state.options;
					var rows = state.filterSource.rows;
					for(var i=0; i<rows.length; i++){
						if (rows[i][opts.idField] == id){
							rows.splice(i, 1);
							state.filterSource.total--;
							break;
						}
					}
				}
			});
			return removeMethod2(jq, id);
		}
	});

	var extendedOptions = {
		filterMenuIconCls: 'icon-ok',
		filterBtnIconCls: 'icon-filter',
		filterBtnPosition: 'right',
		filterPosition: 'bottom',
		remoteFilter: false,
		showFilterBar: true,
		filterDelay: 400,
		filterRules: [],
		// specify whether the filtered records need to match ALL or ANY of the applied filters
		filterMatchingType: 'all',	// possible values: 'all','any'
		// filterCache: {},
		filterMatcher: function(data){
			var name = getPluginName(this);
			var dg = $(this);
			var state = $.data(this, name);
			var opts = state.options;
			if (opts.filterRules.length){
				var rows = [];
				if (name == 'treegrid'){
					var rr = {};
					$.map(data.rows, function(row){
						if (isMatch(row, row[opts.idField])){
							rr[row[opts.idField]] = row;
							row = getRow(data.rows, row._parentId);
							while(row){
								rr[row[opts.idField]] = row;
								row = getRow(data.rows, row._parentId);
							}
						}
					});
					for(var id in rr){
						rows.push(rr[id]);
					}
				} else {
					for(var i=0; i<data.rows.length; i++){
						var row = data.rows[i];
						if (isMatch(row, i)){
							rows.push(row);
						}
					}
				}
				data = {
					total: data.total - (data.rows.length - rows.length),
					rows: rows
				};
			}
			return data;
			
			function isMatch(row, index){
				var rules = opts.filterRules;
				if (!rules.length){return true;}
				for(var i=0; i<rules.length; i++){
					var rule = rules[i];

					// var source = row[rule.field];
					// var col = dg.datagrid('getColumnOption', rule.field);
					// if (col && col.formatter){
					// 	source = col.formatter(row[rule.field], row, index);
					// }
					
					var col = dg.datagrid('getColumnOption', rule.field);
					var formattedValue = (col && col.formatter) ? col.formatter(row[rule.field], row, index) : undefined;
					var source = opts.val.call(dg[0], row, rule.field, formattedValue);

					if (source == undefined){
						source = '';
					}
					var op = opts.operators[rule.op];
					var matched = op.isMatch(source, rule.value);
					if (opts.filterMatchingType == 'any'){
						if (matched){return true;}
					} else {
						if (!matched){return false;}
					}
				}
				return opts.filterMatchingType == 'all';
			}
			function getRow(rows, id){
				for(var i=0; i<rows.length; i++){
					var row = rows[i];
					if (row[opts.idField] == id){
						return row;
					}
				}
				return null;
			}
		},
		defaultFilterType: 'text',
		defaultFilterOperator: 'contains',
		defaultFilterOptions: {
			onInit: function(target){
				var name = getPluginName(target);
				var opts = $(target)[name]('options');
				var field = $(this).attr('name');
				var input = $(this);
				if (input.data('textbox')){
					input = input.textbox('textbox');
				}
				input.unbind('.filter').bind('keydown.filter', function(e){
					var t = $(this);
					if (this.timer){
						clearTimeout(this.timer);
					}
					if (e.keyCode == 13){
						_doFilter();
					} else {
						this.timer = setTimeout(function(){
							_doFilter();
						}, opts.filterDelay);
					}
				});
				function _doFilter(){
					var rule = $(target)[name]('getFilterRule', field);
					var value = input.val();
					if (value != ''){
						if ((rule && rule.value!=value) || !rule){
							$(target)[name]('addFilterRule', {
								field: field,
								op: opts.defaultFilterOperator,
								value: value
							});
							$(target)[name]('doFilter');
						}
					} else {
						if (rule){
							$(target)[name]('removeFilterRule', field);
							$(target)[name]('doFilter');
						}
					}
				}
			}
		},
		filterStringify: function(data){
			return JSON.stringify(data);
		},
		// the function to retrieve the field value of a row to match the filter rule
		val: function(row, field, formattedValue){
			return formattedValue || row[field];
		},
		onClickMenu: function(item,button){}
	};
	$.extend($.fn.datagrid.defaults, extendedOptions);
	$.extend($.fn.treegrid.defaults, extendedOptions);
	
	// filter types
	$.fn.datagrid.defaults.filters = $.extend({}, $.fn.datagrid.defaults.editors, {
		label: {
			init: function(container, options){
				return $('<span></span>').appendTo(container);
			},
			getValue: function(target){
				return $(target).html();
			},
			setValue: function(target, value){
				$(target).html(value);
			},
			resize: function(target, width){
				$(target)._outerWidth(width)._outerHeight(22);
			}
		}
	});
	$.fn.treegrid.defaults.filters = $.fn.datagrid.defaults.filters;
	
	// filter operators
	$.fn.datagrid.defaults.operators = {
		nofilter: {
			text: 'No Filter'
		},
		contains: {
			text: 'Contains',
			isMatch: function(source, value){
				source = String(source);
				value = String(value);
				return source.toLowerCase().indexOf(value.toLowerCase()) >= 0;
			}
		},
		equal: {
			text: 'Equal',
			isMatch: function(source, value){
				return source == value;
			}
		},
		notequal: {
			text: 'Not Equal',
			isMatch: function(source, value){
				return source != value;
			}
		},
		beginwith: {
			text: 'Begin With',
			isMatch: function(source, value){
				source = String(source);
				value = String(value);
				return source.toLowerCase().indexOf(value.toLowerCase()) == 0;
			}
		},
		endwith: {
			text: 'End With',
			isMatch: function(source, value){
				source = String(source);
				value = String(value);
				return source.toLowerCase().indexOf(value.toLowerCase(), source.length - value.length) !== -1;
			}
		},
		less: {
			text: 'Less',
			isMatch: function(source, value){
				return source < value;
			}
		},
		lessorequal: {
			text: 'Less Or Equal',
			isMatch: function(source, value){
				return source <= value;
			}
		},
		greater: {
			text: 'Greater',
			isMatch: function(source, value){
				return source > value;
			}
		},
		greaterorequal: {
			text: 'Greater Or Equal',
			isMatch: function(source, value){
				return source >= value;
			}
		}
	};
	$.fn.treegrid.defaults.operators = $.fn.datagrid.defaults.operators;
	
	function resizeFilter(target, field){
		var toFixColumnSize = false;
		var dg = $(target);
		var header = dg.datagrid('getPanel').find('div.datagrid-header');
		var tr = header.find('.datagrid-header-row:not(.datagrid-filter-row)');
		var ff = field ? header.find('.datagrid-filter[name="'+field+'"]') : header.find('.datagrid-filter');
		ff.each(function(){
			var name = $(this).attr('name');
			var col = dg.datagrid('getColumnOption', name);
			var cc = $(this).closest('div.datagrid-filter-c');
			var btn = cc.find('a.datagrid-filter-btn');
			var cell = tr.find('td[field="'+name+'"] .datagrid-cell');
			var cellWidth = cell._outerWidth();
			if (cellWidth != _getContentWidth(cc)){
				this.filter.resize(this, cellWidth - btn._outerWidth());
			}
			if (cc.width() > col.boxWidth+col.deltaWidth-1){
				col.boxWidth = cc.width() - col.deltaWidth + 1;
				col.width = col.boxWidth + col.deltaWidth;
				toFixColumnSize = true;
			}
		});
		if (toFixColumnSize){
			$(target).datagrid('fixColumnSize');			
		}

		function _getContentWidth(cc){
			var w = 0;
			$(cc).children(':visible').each(function(){
				w += $(this)._outerWidth();
			});
			return w;
		}
	}
	
	function getFilterComponent(target, field){
		var header = $(target).datagrid('getPanel').find('div.datagrid-header');
		return header.find('tr.datagrid-filter-row td[field="'+field+'"] .datagrid-filter');
	}
	
	/**
	 * get filter rule index, return -1 if not found.
	 */
	function getRuleIndex(target, field){
		var name = getPluginName(target);
		var rules = $(target)[name]('options').filterRules;
		for(var i=0; i<rules.length; i++){
			if (rules[i].field == field){
				return i;
			}
		}
		return -1;
	}

	function getFilterRule(target, field){
		var name = getPluginName(target);
		var rules = $(target)[name]('options').filterRules;
		var index = getRuleIndex(target, field);
		if (index >= 0){
			return rules[index];
		} else {
			return null;
		}
	}
	
	function addFilterRule(target, param){
		var name = getPluginName(target);
		var opts = $(target)[name]('options');
		var rules = opts.filterRules;

		if (param.op == 'nofilter'){
			removeFilterRule(target, param.field);
		} else {
			var index = getRuleIndex(target, param.field);
			if (index >= 0){
				$.extend(rules[index], param);
			} else {
				rules.push(param);
			}
		}

		var input = getFilterComponent(target, param.field);
		if (input.length){
			if (param.op != 'nofilter'){
				var value = input.val();
				if (input.data('textbox')){
					value = input.textbox('getText');
				}
				if (value != param.value){
					input[0].filter.setValue(input, param.value);					
				}
			}
			var menu = input[0].menu;
			if (menu){
				menu.find('.'+opts.filterMenuIconCls).removeClass(opts.filterMenuIconCls);
				var item = menu.menu('findItem', opts.operators[param.op]['text']);
				menu.menu('setIcon', {
					target: item.target,
					iconCls: opts.filterMenuIconCls
				});
			}
		}
	}
	
	function removeFilterRule(target, field){
		var name = getPluginName(target);
		var dg = $(target);
		var opts = dg[name]('options');
		if (field){
			var index = getRuleIndex(target, field);
			if (index >= 0){
				opts.filterRules.splice(index, 1);
			}
			_clear([field]);
		} else {
			opts.filterRules = [];
			var fields = dg.datagrid('getColumnFields',true).concat(dg.datagrid('getColumnFields'));
			_clear(fields);
		}
		
		function _clear(fields){
			for(var i=0; i<fields.length; i++){
				var input = getFilterComponent(target, fields[i]);
				if (input.length){
					input[0].filter.setValue(input, '');
					var menu = input[0].menu;
					if (menu){
						menu.find('.'+opts.filterMenuIconCls).removeClass(opts.filterMenuIconCls);
					}
				}
			}
		}
	}
	
	function doFilter(target){
		var name = getPluginName(target);
		var state = $.data(target, name);
		var opts = state.options;
		if (opts.remoteFilter){
			$(target)[name]('load');
		} else {
			if (opts.view.type == 'scrollview' && state.data.firstRows && state.data.firstRows.length){
				state.data.rows = state.data.firstRows;
			}
			$(target)[name]('getPager').pagination('refresh', {pageNumber:1});
			$(target)[name]('options').pageNumber = 1;
			$(target)[name]('loadData', state.filterSource || state.data);
		}
	}
	
	function translateTreeData(target, children, pid){
		var opts = $(target).treegrid('options');
		if (!children || !children.length){return []}
		var rows = [];
		$.map(children, function(item){
			item._parentId = pid;
			rows.push(item);
			rows = rows.concat(translateTreeData(target, item.children, item[opts.idField]));
		});
		$.map(rows, function(row){
			row.children = undefined;
		});
		return rows;
	}

	function myLoadFilter(data, parentId){
		var target = this;
		var name = getPluginName(target);
		var state = $.data(target, name);
		var opts = state.options;

		if (name == 'datagrid' && $.isArray(data)){
			data = {
				total: data.length,
				rows: data
			};
		} else if (name == 'treegrid' && $.isArray(data)){
			var rows = translateTreeData(target, data, parentId);
			data = {
				total: rows.length,
				rows: rows
			}
		}
		if (!opts.remoteFilter){
			if (!state.filterSource){
				state.filterSource = data;
			} else {
				if (!opts.isSorting) {
					if (name == 'datagrid'){
						state.filterSource = data;
					} else {
						state.filterSource.total += data.length;
						state.filterSource.rows = state.filterSource.rows.concat(data.rows);
						if (parentId){
							return opts.filterMatcher.call(target, data);
						}
					}
				} else {
					opts.isSorting = undefined;
				}
			}
			if (!opts.remoteSort && opts.sortName){
				var names = opts.sortName.split(',');
				var orders = opts.sortOrder.split(',');
				var dg = $(target);
				state.filterSource.rows.sort(function(r1,r2){
					var r = 0;
					for(var i=0; i<names.length; i++){
						var sn = names[i];
						var so = orders[i];
						var col = dg.datagrid('getColumnOption', sn);
						var sortFunc = col.sorter || function(a,b){
							return a==b ? 0 : (a>b?1:-1);
						};
						r = sortFunc(r1[sn], r2[sn]) * (so=='asc'?1:-1);
						if (r != 0){
							return r;
						}
					}
					return r;
				});
			}
			data = opts.filterMatcher.call(target, {
				total: state.filterSource.total,
				rows: state.filterSource.rows
			});

			if (opts.pagination){
				var dg = $(target);
				var pager = dg[name]('getPager');
				pager.pagination({
					onSelectPage:function(pageNum, pageSize){
	                    opts.pageNumber = pageNum;
	                    opts.pageSize = pageSize;
	                    pager.pagination('refresh',{
	                        pageNumber:pageNum,
	                        pageSize:pageSize
	                    });
	                    //dg.datagrid('loadData', state.filterSource);
	                    dg[name]('loadData', state.filterSource);
					},
					onBeforeRefresh:function(){
						dg[name]('reload');
						return false;
					}
				});
				if (name == 'datagrid'){
					var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
					var end = start + parseInt(opts.pageSize);
					data.rows = data.rows.slice(start, end);
				} else {
			        var topRows = [];
			        var childRows = [];
			        $.map(data.rows, function(row){
			        	row._parentId ? childRows.push(row) : topRows.push(row);
			        });
			        data.total = topRows.length;
			        var start = (opts.pageNumber-1)*parseInt(opts.pageSize);  
			        var end = start + parseInt(opts.pageSize);  
					data.rows = topRows.slice(start, end).concat(childRows);
				}
			}
			$.map(data.rows, function(row){
				row.children = undefined;
			});
		}
		return data;
	}
	
	function init(target, filters){
		filters = filters || [];
		var name = getPluginName(target);
		var state = $.data(target, name);
		var opts = state.options;
		if (!opts.filterRules.length){
			opts.filterRules = [];
		}
		opts.filterCache = opts.filterCache || {};
		var dgOpts = $.data(target, 'datagrid').options;
		
		var onResize = dgOpts.onResize;
		dgOpts.onResize = function(width,height){
			resizeFilter(target);
			onResize.call(this, width, height);
		}
		var onBeforeSortColumn = dgOpts.onBeforeSortColumn;
		dgOpts.onBeforeSortColumn = function(sort, order){
			var result = onBeforeSortColumn.call(this, sort, order);
			if (result != false){
				opts.isSorting = true;				
			}
			return result;
		};

		var onResizeColumn = opts.onResizeColumn;
		opts.onResizeColumn = function(field,width){
			var fc = $(this).datagrid('getPanel').find('.datagrid-header .datagrid-filter-c');
			var focusOne = fc.find('.datagrid-filter:focus');
			fc.hide();
			$(target).datagrid('fitColumns');
			if (opts.fitColumns){
				resizeFilter(target);
			} else {
				resizeFilter(target, field);
			}
			fc.show();
			focusOne.blur().focus();
			onResizeColumn.call(target, field, width);
		};
		var onBeforeLoad = opts.onBeforeLoad;
		opts.onBeforeLoad = function(param1, param2){
			if (param1){
				param1.filterRules = opts.filterStringify(opts.filterRules);
			}
			if (param2){
				param2.filterRules = opts.filterStringify(opts.filterRules);
			}
			var result = onBeforeLoad.call(this, param1, param2);
			if (result != false && opts.url){
				if (name == 'datagrid'){
					state.filterSource = null;
				} else if (name == 'treegrid' && state.filterSource){
					if (param1){
						var id = param1[opts.idField];	// the id of the expanding row
						var rows = state.filterSource.rows || [];
						for(var i=0; i<rows.length; i++){
							if (id == rows[i]._parentId){	// the expanding row has children
								return false;
							}
						}
					} else {
						state.filterSource = null;
					}
				}
			}
			return result;
		};

		// opts.loadFilter = myLoadFilter;
		opts.loadFilter = function(data, parentId){
			var d = opts.oldLoadFilter.call(this, data, parentId);
			return myLoadFilter.call(this, d, parentId);
		};
		
		initCss();
		createFilter(true);
		createFilter();
		if (opts.fitColumns){
			setTimeout(function(){
				resizeFilter(target);
			}, 0);
		}

		$.map(opts.filterRules, function(rule){
			addFilterRule(target, rule);
		});
		
		function initCss(){
			if (!$('#datagrid-filter-style').length){
				$('head').append(
					'<style id="datagrid-filter-style">' +
					'a.datagrid-filter-btn{display:inline-block;width:22px;height:22px;margin:0;vertical-align:top;cursor:pointer;opacity:0.6;filter:alpha(opacity=60);}' +
					'a:hover.datagrid-filter-btn{opacity:1;filter:alpha(opacity=100);}' +
					'.datagrid-filter-row .textbox,.datagrid-filter-row .textbox .textbox-text{-moz-border-radius:0;-webkit-border-radius:0;border-radius:0;}' +
					'.datagrid-filter-row input{margin:0;-moz-border-radius:0;-webkit-border-radius:0;border-radius:0;}' +
					'.datagrid-filter-c{overflow:hidden}' +
					'.datagrid-filter-cache{position:absolute;width:10px;height:10px;left:-99999px;}' +
					'</style>'
				);
			}
		}
		
		/**
		 * create filter component
		 */
		function createFilter(frozen){
			var dc = state.dc;
			var fields = $(target).datagrid('getColumnFields', frozen);
			if (frozen && opts.rownumbers){
				fields.unshift('_');
			}
			var table = (frozen?dc.header1:dc.header2).find('table.datagrid-htable');
			
			// clear the old filter component
			table.find('.datagrid-filter').each(function(){
				if (this.filter.destroy){
					this.filter.destroy(this);
				}
				if (this.menu){
					$(this.menu).menu('destroy');
				}
			});
			table.find('tr.datagrid-filter-row').remove();
			
			var tr = $('<tr class="datagrid-header-row datagrid-filter-row"></tr>');
			if (opts.filterPosition == 'bottom'){
				tr.appendTo(table.find('tbody'));
			} else {
				tr.prependTo(table.find('tbody'));
			}
			if (!opts.showFilterBar){
				tr.hide();
			}
			
			for(var i=0; i<fields.length; i++){
				var field = fields[i];
				var col = $(target).datagrid('getColumnOption', field);
				var td = $('<td></td>').attr('field', field).appendTo(tr);
				if (col && col.hidden){
					td.hide();
				}
				if (field == '_'){
					continue;
				}
				if (col && (col.checkbox || col.expander)){
					continue;
				}

				var fopts = getFilter(field);
				if (fopts){
					$(target)[name]('destroyFilter', field);	// destroy the old filter component
				} else {
					fopts = $.extend({}, {
						field: field,
						type: opts.defaultFilterType,
						options: opts.defaultFilterOptions
					});
				}

				var div = opts.filterCache[field];
				if (!div){
					div = $('<div class="datagrid-filter-c"></div>').appendTo(td);
					var filter = opts.filters[fopts.type];
					var input = filter.init(div, $.extend({height:24},fopts.options||{}));
					input.addClass('datagrid-filter').attr('name', field);
					input[0].filter = filter;
					input[0].menu = createFilterButton(div, fopts.op);
					if (fopts.options){
						if (fopts.options.onInit){
							fopts.options.onInit.call(input[0], target);
						}
					} else {
						opts.defaultFilterOptions.onInit.call(input[0], target);
					}
					opts.filterCache[field] = div;
					resizeFilter(target, field);
				} else {
					div.appendTo(td);
				}
			}
		}
		
		function createFilterButton(container, operators){
			if (!operators){return null;}
			
			var btn = $('<a class="datagrid-filter-btn">&nbsp;</a>').addClass(opts.filterBtnIconCls);
			if (opts.filterBtnPosition == 'right'){
				btn.appendTo(container);
			} else {
				btn.prependTo(container);
			}

			var menu = $('<div></div>').appendTo('body');
			$.map(['nofilter'].concat(operators), function(item){
				var op = opts.operators[item];
				if (op){
					$('<div></div>').attr('name', item).html(op.text).appendTo(menu);
				}
			});
			menu.menu({
				alignTo:btn,
				onClick:function(item){
					var btn = $(this).menu('options').alignTo;
					var td = btn.closest('td[field]');
					var field = td.attr('field');
					var input = td.find('.datagrid-filter');
					var value = input[0].filter.getValue(input);
					
					if (opts.onClickMenu.call(target, item, btn, field) == false){
						return;
					}
					
					addFilterRule(target, {
						field: field,
						op: item.name,
						value: value
					});
					
					doFilter(target);
				}
			});

			btn[0].menu = menu;
			btn.bind('click', {menu:menu}, function(e){
				$(this.menu).menu('show');
				return false;
			});
			return menu;
		}
		
		function getFilter(field){
			for(var i=0; i<filters.length; i++){
				var filter = filters[i];
				if (filter.field == field){
					return filter;
				}
			}
			return null;
		}
	}
	
	$.extend($.fn.datagrid.methods, {
		enableFilter: function(jq, filters){
			return jq.each(function(){
				var name = getPluginName(this);
				var opts = $.data(this, name).options;
				if (opts.oldLoadFilter){
					if (filters){
						$(this)[name]('disableFilter');
					} else {
						return;
					}
				}
				opts.oldLoadFilter = opts.loadFilter;
				init(this, filters);
				$(this)[name]('resize');
				if (opts.filterRules.length){
					if (opts.remoteFilter){
						doFilter(this);
					} else if (opts.data){
						doFilter(this);
					}
				}
			});
		},
		disableFilter: function(jq){
			return jq.each(function(){
				var name = getPluginName(this);
				var state = $.data(this, name);
				var opts = state.options;
				if (!opts.oldLoadFilter){
					return;
				}
				var dc = $(this).data('datagrid').dc;
				var div = dc.view.children('.datagrid-filter-cache');
				if (!div.length){
					div = $('<div class="datagrid-filter-cache"></div>').appendTo(dc.view);
				}
				for(var field in opts.filterCache){
					$(opts.filterCache[field]).appendTo(div);
				}
				var data = state.data;
				if (state.filterSource){
					data = state.filterSource;
					$.map(data.rows, function(row){
						row.children = undefined;
					});
				}
				dc.header1.add(dc.header2).find('tr.datagrid-filter-row').remove();
				opts.loadFilter = opts.oldLoadFilter || undefined;
				opts.oldLoadFilter = null;
				$(this)[name]('resize');
				$(this)[name]('loadData', data);

				// $(this)[name]({
				// 	data: data,
				// 	loadFilter: (opts.oldLoadFilter||undefined),
				// 	oldLoadFilter: null
				// });
			});
		},
		destroyFilter: function(jq, field){
			return jq.each(function(){
				var name = getPluginName(this);
				var state = $.data(this, name);
				var opts = state.options;
				if (field){
					_destroy(field);
				} else {
					for(var f in opts.filterCache){
						_destroy(f);
					}
					$(this).datagrid('getPanel').find('.datagrid-header .datagrid-filter-row').remove();
					$(this).data('datagrid').dc.view.children('.datagrid-filter-cache').remove();
					opts.filterCache = {};
					$(this)[name]('resize');
					$(this)[name]('disableFilter');
				}

				function _destroy(field){
					var c = $(opts.filterCache[field]);
					var input = c.find('.datagrid-filter');
					if (input.length){
						var filter = input[0].filter;
						if (filter.destroy){
							filter.destroy(input[0]);
						}
					}
					c.find('.datagrid-filter-btn').each(function(){
						$(this.menu).menu('destroy');
					});
					c.remove();
					opts.filterCache[field] = undefined;
				}
			});
		},
		getFilterRule: function(jq, field){
			return getFilterRule(jq[0], field);
		},
		addFilterRule: function(jq, param){
			return jq.each(function(){
				addFilterRule(this, param);
			});
		},
		removeFilterRule: function(jq, field){
			return jq.each(function(){
				removeFilterRule(this, field);
			});
		},
		doFilter: function(jq){
			return jq.each(function(){
				doFilter(this);
			});
		},
		getFilterComponent: function(jq, field){
			return getFilterComponent(jq[0], field);
		},
		resizeFilter: function(jq, field){
			return jq.each(function(){
				resizeFilter(this, field);
			});
		}
	});
})(jQuery);
