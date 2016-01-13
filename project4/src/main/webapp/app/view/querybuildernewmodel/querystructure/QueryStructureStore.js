Ext.define('Project4.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Project4.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Project4.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
