define(["backbone", "routes/idea/idea"], function(Backbone, Idea){
	return Backbone.Collection.extend({
		model: Idea,
		url: "/api/idea"
	});
});