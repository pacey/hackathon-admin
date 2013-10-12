define(["marionette"], function(Marionette){
	return Marionette.AppRouter.extend({
		appRoutes: {
			"idea": "listIdea",
			"idea/add": "addIdea",
			"idea/:ideaId": "updateIdea"
		}
	});
});