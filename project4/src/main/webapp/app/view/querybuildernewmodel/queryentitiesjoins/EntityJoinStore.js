Ext.define('Project4.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Project4.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Project4.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
