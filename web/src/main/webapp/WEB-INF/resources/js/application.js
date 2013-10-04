define(["marionette", "navigation/navigationController"], function(Marionette, NavigationController){
	var application = new Marionette.Application();
	application.addInitializer(function(options){
		application.addRegions({
			mainRegion: "#content",
			navigationRegion: "#navigation"
		});
		var navigationController = new NavigationController({
			navigationRegion: application.navigationRegion
		});
		navigationController.show();
	});
	return application;
});