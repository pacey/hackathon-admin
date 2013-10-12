define(["marionette", "routes/idea/ideaView"], function(Marionette, IdeaView){
	return Marionette.CollectionView.extend({
		tagName: "ul",
		className: "col-md-12 list-unstyled",
		itemView: IdeaView
	});
});