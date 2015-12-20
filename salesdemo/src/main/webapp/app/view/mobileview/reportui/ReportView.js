Ext.define('Salesdemo.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Salesdemo.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Salesdemo.view.mobileview.reportui.datachart.DataChartViewTab',
			'Salesdemo.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Salesdemo.view.mobileview.reportui.ReportViewController' ,
			'Salesdemo.view.mobileview.fw.DataPointPanel',
			'Salesdemo.view.mobileview.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',

	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
