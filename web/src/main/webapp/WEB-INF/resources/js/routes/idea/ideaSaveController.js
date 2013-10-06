define(["underscore", "marionette", "routes/idea/ideaRouter", "routes/idea/idea", "routes/idea/ideaSaveUpdateView"], function(_, Marionette, IdeaRouter, Idea, IdeaSaveUpdateView){
	return Marionette.Controller.extend({
		initialize: function(options){
			this.contentRegion = options.contentRegion;
			this.ideaRouter = new IdeaRouter({
				controller: this
			});
			_.bindAll(this, "onIdeaSaved");
		},
		addIdea: function(){
			this.currentView = new IdeaSaveUpdateView({
				model: new Idea()
			});
			this.contentRegion.show(this.currentView);
			this.listenTo(this.currentView, "idea:save", function(args){
				args.model.save(null, {
					success: this.onIdeaSaved
				});
			});
		},
		updateIdea: function(ideaId){
			//TODO: this doesn't work yet
			this.currentIdea = new Idea();
			this.currentIdea.set("id", ideaId);
			this.currentIdea.fetch(function(){
				this.currentView = new IdeaSaveUpdateView({
					model: this.currentIdea
				});
				this.contentRegion.show(this.currentView);
				this.listenTo(this.currentView, "idea:save", function(args){

				});
			});
		},
		onIdeaSaved: function(){
			this.ideaRouter.navigate("", {
				trigger: true
			});
		}
	});
});