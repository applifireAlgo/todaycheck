Ext.define('Salesdemo.view.querybuildernewmodel.querycondition.QueryGroupByTree', {
	extend : 'Ext.tree.TreePanel',
	requires:['Salesdemo.view.querybuildernewmodel.querycondition.QueryGroupByController'],
	controller:'query-groupby',
	xtype : 'query-groupby',
	useArrows:true,
	rootVisible: false,
	loadMask :true,
	folderSort :true,
    title: '',
    listeners:{
		scope:'controller',
		itemdblclick:'onItemdblclick',
		checkchange :'onCheckChange'
    }
});
