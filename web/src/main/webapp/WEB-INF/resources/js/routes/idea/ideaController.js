define(["underscore", "marionette", "routes/idea/ideaRouter", "routes/idea/idea", "routes/idea/ideaSaveUpdateView", "notification/notification", "routes/idea/ideaCollection", "routes/idea/ideaCollectionView"], function(_, Marionette, IdeaRouter, Idea, IdeaSaveUpdateView, Notification, IdeaCollection, IdeaCollectionView){
	return Marionette.Controller.extend({
		initialize: function(options){
			this.contentRegion = options.contentRegion;
			this.notificationController = options.notificationController;
			this.ideaRouter = new IdeaRouter({
				controller: this
			});
			this.ideaSaveUpdateView = new IdeaSaveUpdateView();
			this.listenTo(this.ideaSaveUpdateView, "idea:add", function(args){
				args.model.save(null, {
					success: this.onIdeaAdded
				});
			});
			this.listenTo(this.ideaSaveUpdateView, "idea:update", function(args){
				args.model.save(null, {
					success: this.onIdeaUpdated
				});
			});
			_.bindAll(this, "onIdeaAdded", "onIdeaUpdated", "showAddUpdate", "showList");
		},
		addIdea: function(){
			this.showAddUpdate(new Idea());
		},
		updateIdea: function(ideaId){
			var idea = new Idea({
				id: ideaId
			});
			idea.fetch({
				success: this.showAddUpdate
			});
		},
		listIdea: function(){
			var ideaCollection = new IdeaCollection();
			ideaCollection.fetch({
				success: this.showList
			});
		},
		showList: function(ideaCollection){
			this.contentRegion.show(new IdeaCollectionView({
				collection: ideaCollection
			}))
		},
		showAddUpdate: function(idea){
			this.ideaSaveUpdateView.model = idea;
			this.contentRegion.show(this.ideaSaveUpdateView);
		},
		onIdeaAdded: function(idea){
			this.notificationController.addNotification(new Notification({
				type: "success",
				message: "Your idea was created successfully"
			}));
			this.ideaRouter.navigate("idea/" + idea.get("id"), {
				trigger: true
			});
		},
		onIdeaUpdated: function(idea){
			this.notificationController.addNotification(new Notification({
				type: "success",
				message: "Your idea was updated successfully"
			}));
			this.ideaRouter.navigate("idea/" + idea.get("id"), {
				trigger: true
			});
		}
	});
});