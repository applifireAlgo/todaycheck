Ext.define('Project4.project4.web.com.view.location.StateMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "StateMainController",
     "restURL": "/State",
     "defaults": {
          "split": true
     },
     "requires": ["Project4.project4.shared.com.model.location.StateModel", "Project4.project4.web.com.controller.location.StateMainController", "Project4.project4.shared.com.model.location.CountryModel", "Project4.project4.shared.com.viewmodel.location.StateViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "State",
               "name": "StateTreeContainer",
               "itemId": "StateTreeContainer",
               "restURL": "/State",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "StateTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country Code",
                         "fieldId": "B870DA81-5CD8-4EEA-81BF-CB312A4EFEEA",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project4.project4.shared.com.model.location.CountryModel"
                         }
                    }, {
                         "name": "stateName",
                         "itemId": "stateName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Name",
                         "fieldId": "D552483B-E251-4DF9-8E8C-FB968AA50AA2",
                         "minLength": "0",
                         "maxLength": "256"
                    }, {
                         "name": "stateCode",
                         "itemId": "stateCode",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "State Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code",
                         "fieldId": "F7FC3BD7-C94C-41E2-8132-A04B2D54BE14",
                         "minValue": "0",
                         "maxValue": "2"
                    }, {
                         "name": "stateCodeChar2",
                         "itemId": "stateCodeChar2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Code 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code 2",
                         "fieldId": "FB7102A2-7141-4D74-8FAC-CB46484C2175",
                         "minLength": "0",
                         "maxLength": "32"
                    }, {
                         "name": "stateCodeChar3",
                         "itemId": "stateCodeChar3",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Code 3",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code 3",
                         "fieldId": "128B533A-9B1B-4C38-A28C-FD6302F9DFFC",
                         "minLength": "0",
                         "maxLength": "32"
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "StateViewModel",
                    "xtype": "form",
                    "displayName": "State",
                    "title": "State",
                    "name": "State",
                    "itemId": "State",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Id<font color='red'> *<\/font>",
                         "fieldId": "4DE43FED-68FB-4952-A5A1-1A3C7D67CA58",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "stateId",
                         "bind": "{stateId}"
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B870DA81-5CD8-4EEA-81BF-CB312A4EFEEA",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project4.project4.shared.com.model.location.CountryModel"
                         },
                         "bindable": "countryId",
                         "bind": "{countryId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateName",
                         "itemId": "stateName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "D552483B-E251-4DF9-8E8C-FB968AA50AA2",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "stateName",
                         "bind": "{stateName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCode",
                         "itemId": "stateCode",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "State Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code",
                         "fieldId": "F7FC3BD7-C94C-41E2-8132-A04B2D54BE14",
                         "minValue": "0",
                         "maxValue": "2",
                         "bindable": "stateCode",
                         "bind": "{stateCode}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCodeChar2",
                         "itemId": "stateCodeChar2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Code 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code 2<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "FB7102A2-7141-4D74-8FAC-CB46484C2175",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "stateCodeChar2",
                         "bind": "{stateCodeChar2}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCodeChar3",
                         "itemId": "stateCodeChar3",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Code 3",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code 3",
                         "fieldId": "128B533A-9B1B-4C38-A28C-FD6302F9DFFC",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "stateCodeChar3",
                         "bind": "{stateCodeChar3}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateDescription",
                         "itemId": "stateDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "State Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Description",
                         "fieldId": "E1248632-A2C0-486D-9882-8077D7BAA131",
                         "bindable": "stateDescription",
                         "bind": "{stateDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateFlag",
                         "itemId": "stateFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "849007FF-B472-4297-B15F-2812544227B6",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "stateFlag",
                         "bind": "{stateFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCapital",
                         "itemId": "stateCapital",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Capital",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capital",
                         "fieldId": "ADDA254E-6CC3-4B22-B0E3-BC99C3584300",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "stateCapital",
                         "bind": "{stateCapital}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCapitalLatitude",
                         "itemId": "stateCapitalLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Capitial Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capitial Latitude",
                         "fieldId": "45AC6BE7-A36A-470E-91DD-D1DFB7402403",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "stateCapitalLatitude",
                         "bind": "{stateCapitalLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCapitalLongitude",
                         "itemId": "stateCapitalLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Capitial Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capitial Longitude",
                         "fieldId": "1C13B83A-62A8-465F-A8E9-44E5C3E71F38",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "stateCapitalLongitude",
                         "bind": "{stateCapitalLongitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "9012D72F-9AC0-4C18-93E8-A721B5570320",
                         "bindable": "versionId",
                         "bind": "{versionId}",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 939,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 939,
                              "customId": 305
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 939,
                              "customId": 306,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 939,
                              "customId": 307,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "State",
                    "title": "Details Grid",
                    "name": "StateGrid",
                    "itemId": "StateGrid",
                    "restURL": "/State",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "State Id",
                         "dataIndex": "stateId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Country Code",
                         "dataIndex": "countryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "State Name",
                         "dataIndex": "stateName",
                         "flex": 1
                    }, {
                         "header": "State Code",
                         "dataIndex": "stateCode",
                         "flex": 1
                    }, {
                         "header": "State Code 2",
                         "dataIndex": "stateCodeChar2",
                         "flex": 1
                    }, {
                         "header": "State Code 3",
                         "dataIndex": "stateCodeChar3",
                         "flex": 1
                    }, {
                         "header": "State Description",
                         "dataIndex": "stateDescription",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "stateFlag",
                         "flex": 1
                    }, {
                         "header": "Capital",
                         "dataIndex": "stateCapital",
                         "flex": 1
                    }, {
                         "header": "Capitial Latitude",
                         "dataIndex": "stateCapitalLatitude",
                         "flex": 1
                    }, {
                         "header": "Capitial Longitude",
                         "dataIndex": "stateCapitalLongitude",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "StateViewModel",
               "xtype": "form",
               "displayName": "State",
               "title": "State",
               "name": "State",
               "itemId": "State",
               "bodyPadding": 10,
               "items": [{
                    "name": "stateId",
                    "itemId": "stateId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "State Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Id<font color='red'> *<\/font>",
                    "fieldId": "4DE43FED-68FB-4952-A5A1-1A3C7D67CA58",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "stateId",
                    "bind": "{stateId}"
               }, {
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B870DA81-5CD8-4EEA-81BF-CB312A4EFEEA",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project4.project4.shared.com.model.location.CountryModel"
                    },
                    "bindable": "countryId",
                    "bind": "{countryId}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateName",
                    "itemId": "stateName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "State Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "D552483B-E251-4DF9-8E8C-FB968AA50AA2",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "stateName",
                    "bind": "{stateName}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCode",
                    "itemId": "stateCode",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "State Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Code",
                    "fieldId": "F7FC3BD7-C94C-41E2-8132-A04B2D54BE14",
                    "minValue": "0",
                    "maxValue": "2",
                    "bindable": "stateCode",
                    "bind": "{stateCode}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCodeChar2",
                    "itemId": "stateCodeChar2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "State Code 2",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Code 2<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "FB7102A2-7141-4D74-8FAC-CB46484C2175",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "stateCodeChar2",
                    "bind": "{stateCodeChar2}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCodeChar3",
                    "itemId": "stateCodeChar3",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "State Code 3",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Code 3",
                    "fieldId": "128B533A-9B1B-4C38-A28C-FD6302F9DFFC",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "stateCodeChar3",
                    "bind": "{stateCodeChar3}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateDescription",
                    "itemId": "stateDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "State Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Description",
                    "fieldId": "E1248632-A2C0-486D-9882-8077D7BAA131",
                    "bindable": "stateDescription",
                    "bind": "{stateDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateFlag",
                    "itemId": "stateFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "849007FF-B472-4297-B15F-2812544227B6",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "stateFlag",
                    "bind": "{stateFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCapital",
                    "itemId": "stateCapital",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Capital",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capital",
                    "fieldId": "ADDA254E-6CC3-4B22-B0E3-BC99C3584300",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "stateCapital",
                    "bind": "{stateCapital}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCapitalLatitude",
                    "itemId": "stateCapitalLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Capitial Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capitial Latitude",
                    "fieldId": "45AC6BE7-A36A-470E-91DD-D1DFB7402403",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "stateCapitalLatitude",
                    "bind": "{stateCapitalLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCapitalLongitude",
                    "itemId": "stateCapitalLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Capitial Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capitial Longitude",
                    "fieldId": "1C13B83A-62A8-465F-A8E9-44E5C3E71F38",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "stateCapitalLongitude",
                    "bind": "{stateCapitalLongitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "9012D72F-9AC0-4C18-93E8-A721B5570320",
                    "bindable": "versionId",
                    "bind": "{versionId}",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 939,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 939,
                         "customId": 305
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 939,
                         "customId": 306,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 939,
                         "customId": 307,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});