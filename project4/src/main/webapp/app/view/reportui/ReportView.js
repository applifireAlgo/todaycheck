Ext.define('Project4.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Project4.view.reportui.querycriteria.QueryCriteriaView',
			'Project4.view.reportui.datachart.DataChartViewTab',
			'Project4.view.reportui.datachart.DataChartViewPanel',
			'Project4.view.reportui.ReportViewController' ,
			'Project4.view.fw.MainDataPointPanel',
			'Project4.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
