Ext.define('Salesdemo.view.databrowsercalendar.DBCalendar', {
	extend : 'Salesdemo.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Salesdemo.view.databrowsercalendar.DBCalendarController',
	             'Salesdemo.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
