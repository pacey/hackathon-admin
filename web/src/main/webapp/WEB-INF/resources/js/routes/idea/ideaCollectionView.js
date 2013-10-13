define(["marionette", "routes/idea/ideaView", "routes/idea/ideaCollectionEmptyView"], function(Marionette, IdeaView, IdeaCollectionEmptyView){
	return Marionette.CollectionView.extend({
		tagName: "ul",
		className: "col-md-12 list-unstyled",
		itemView: IdeaView,
		emptyView: IdeaCollectionEmptyView
	});
});