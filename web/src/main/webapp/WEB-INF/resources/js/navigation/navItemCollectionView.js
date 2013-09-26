define(["marionette", "navigation/navItemCollection", "navigation/navItemView", "navigation/navItem"], function(Marionette, NavItemCollection, NavItemView, NavItem){
	return Marionette.CollectionView.extend({
		tagName: "ul",
		className: "nav navbar-nav",
		collection: NavItemCollection,
		itemView: NavItemView,
		initialize: function(){
			this.collection = new NavItemCollection();
			this.collection.add(new NavItem({
				href: "#/idea/add",
				text: "Add idea"
			}));
		}
	});
});