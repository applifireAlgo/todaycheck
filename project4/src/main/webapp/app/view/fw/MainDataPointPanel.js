Ext.define('Project4.view.fw.MainDataPointPanel',{
	extend : 'Ext.panel.Panel',
	xtype: 'mainDataPointPanel',
	requires: ['Project4.view.fw.DataPointPanel'],
	bodyStyle : 'background:#fff',
	width:"100%",
	layout : {
		type : 'table',
		columns: 7,
		tableAttrs: {
            style: {
                width: '100%',height:'100%'
            }
        }
	},
	defaults:{padding:'0 0 0 2'},
	items: []
});