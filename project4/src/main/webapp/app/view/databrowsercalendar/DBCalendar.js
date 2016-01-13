Ext.define('Project4.view.databrowsercalendar.DBCalendar', {
	extend : 'Project4.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Project4.view.databrowsercalendar.DBCalendarController',
	             'Project4.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
