Ext.define('Salesdemo.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Salesdemo.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Salesdemo.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
