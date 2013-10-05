define(["marionette", "routes/home/homeController"], function(Marionette, HomeController){
	return Marionette.AppRouter.extend({
		appRoutes: {
			"": "showHomepage"
		}
	});
});