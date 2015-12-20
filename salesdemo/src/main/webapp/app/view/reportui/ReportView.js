Ext.define('Salesdemo.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Salesdemo.view.reportui.querycriteria.QueryCriteriaView',
			'Salesdemo.view.reportui.datachart.DataChartViewTab',
			'Salesdemo.view.reportui.datachart.DataChartViewPanel',
			'Salesdemo.view.reportui.ReportViewController' ,
			'Salesdemo.view.fw.MainDataPointPanel',
			'Salesdemo.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:1000,
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
