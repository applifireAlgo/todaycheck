Ext.define('Project4.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Project4.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Project4.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
