In this Project, we will simulate a simple e-commerce site. This site consists of 3 sets of
players: Platform, Sellers, Customers. Sellers offer Products through the Platform, which are
viewed by Customers, who may then decide to order some of the products.
Customers interact with the system using the Customer Portal. Sellers attach themselves to the
platform, while the Portal is also connected to the platform. Thus all interactions between
customers and sellers are through the platform.
The Portal allows customers to view the list of available product categories. For each category,
they can ask for a listing of available products. On viewing the listing (which can be sorted as
per their preference), they may choose to purchase one or more units of a given product. Once
sold, the product is no longer available to others.
When a customer makes a request (either for listing products or buying products), the portal
relays the request to the platform. The platform, in turn, sends the request to the relevant
sellers, and sends their response back to the portal.
