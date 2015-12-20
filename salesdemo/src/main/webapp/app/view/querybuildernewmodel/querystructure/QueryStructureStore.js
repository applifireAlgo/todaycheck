Ext.define('Salesdemo.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Salesdemo.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Salesdemo.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
