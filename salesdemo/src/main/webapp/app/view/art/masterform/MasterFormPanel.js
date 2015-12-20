Ext.define('Salesdemo.view.art.masterform.MasterFormPanel',
{
	extend :'Ext.form.Panel',
	xtype: 'masterFormPanel',
	itemId : 'masterFormPanel',
	
	requires: ['Salesdemo.view.art.masterform.MasterFormModel','Salesdemo.view.art.masterform.MasterFormViewModel','Salesdemo.view.art.masterform.MasterFormPanelController'],

	//viewModel: 'masterFormViewModel',
	
	controller: 'masterFormPanelController'

});
	