/*
 * This file is generated and updated by Sencha Cmd. You can edit this file as
 * needed for your application, but these edits will have to be merged by
 * Sencha Cmd when upgrading.
 */
Ext.application({
    name: 'Salesdemo',

    extend: 'Salesdemo.Application',
    
/**AppPathDetails**/autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Salesdemo.view.mainleftmenutree.MainPanel':'Salesdemo.view.mobileview.login.Login',
    //autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Salesdemo.view.login.LoginPage':'Salesdemo.view.mobileview.login.LoginPage',//'Salesdemo.view.login.Login'
    	
    //-------------------------------------------------------------------------
    // Most customizations should be made to Salesdemo.Application. If you need to
    // customize this file, doing so below this section reduces the likelihood
    // of merge conflicts when upgrading to new versions of Sencha Cmd.
    //-------------------------------------------------------------------------
});
