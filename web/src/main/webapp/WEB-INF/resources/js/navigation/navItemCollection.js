define(["backbone", "navigation/navItem"], function(Backbone, NavItem){
	return Backbone.Collection.extend({
		model: NavItem
	});
});