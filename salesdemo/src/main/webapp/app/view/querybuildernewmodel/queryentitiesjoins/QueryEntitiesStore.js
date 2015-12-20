Ext.define('Salesdemo.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesStore', {
    extend: 'Ext.data.Store',
   // requires:['Salesdemo.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesModel'],
    autoSync: false,
    model: 'Salesdemo.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesModel',
    data:[]
});
