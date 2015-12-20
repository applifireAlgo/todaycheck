Ext.define('Salesdemo.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Salesdemo.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Salesdemo.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
