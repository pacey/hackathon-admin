define(["marionette", "handlebars", "navigation/navItem", "text!navigation/navItem.html"], function(Marionette, Handlebars, NavItem, NavItemTemplate){
	return Marionette.ItemView.extend({
		tagName: "li",
		className: function(){
			return this.model.get("active") ? "active" : undefined;
		},
		model: NavItem,
		template: Handlebars.compile(NavItemTemplate)
	});
});