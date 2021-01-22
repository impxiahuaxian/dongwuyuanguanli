var myview = $.extend({},$.fn.datagrid.defaults.view,{
	onAfterRender:function(target){
		$.fn.datagrid.defaults.view.onAfterRender.call(this,target);
		$("#.datagrid-btable tbody tr:even").css("backgroundColor","#e0e0e0");
	}
});