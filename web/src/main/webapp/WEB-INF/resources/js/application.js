define(["marionette", "navigation/navItemCollectionView"], function(Marionette, NavItemCollectionView){
	var application = new Marionette.Application();
	application.addInitializer(function(options){
		console.log("application started");
	});
	application.addRegions({
		mainRegion: "#content",
		navigationRegion: ".navbar-collapse"
	});
	application.navigationRegion.show(new NavItemCollectionView());
	return application;
});