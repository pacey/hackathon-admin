define(["marionette"], function(Marionette){
	return Marionette.AppRouter.extend({
		appRoutes: {
			"idea": "addIdea",
			"idea/:ideaId": "updateIdea"
		}
	});
});