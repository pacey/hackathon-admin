define(["marionette", "backbone", "navigation/navigationController", "routes/home/homeController"], function(Marionette, Backbone, NavigationController, HomeController){
	var application = new Marionette.Application();
	application.addInitializer(function(options){
		application.addRegions({
			contentRegion: "#content",
			navigationRegion: "#navigation"
		});
		var navigationController = new NavigationController({
			navigationRegion: application.navigationRegion
		});
		navigationController.show();
		var homeController = new HomeController({
			contentRegion: application.contentRegion
		});
		Backbone.history.start();
	});
	return application;
});