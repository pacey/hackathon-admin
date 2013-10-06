define(["backbone"], function(Bacbone){
	return Backbone.Model.extend({
		urlRoot: "/api/idea"
	});
});