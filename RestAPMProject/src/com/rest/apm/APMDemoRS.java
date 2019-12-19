package com.rest.apm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/apmapp")
@Produces(MediaType.APPLICATION_JSON)
public class APMDemoRS {

	@GET
	@Path("/world")
	public Response helloWorld() {
		return Response.ok("Hello World!").build() ;
	}

	@GET
	@Path("/me")
	public Response hellome() {
		return Response.ok("Hello Me!").build();
	}

	@GET
	@Path("/you")
	public Response helloyou() {
		String resp = "Hello You!";
		return Response.ok(resp).build();
	}

	
	/*@GET
	@Path("/couriers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCoureirs() {

		System.out.println("---> starting T#getCouriers");
		Transaction transaction = ElasticApm.startTransaction();
		transaction.setName("APMDemoRS#getCouriers");
		transaction.setType(Transaction.TYPE_REQUEST);

		SQLiteConnection dbconnect = new SQLiteConnection();

		System.out.println("---> starting S#DBQuery");
		Span dbSpan = transaction.startSpan("db", "sqlite", "query");
		dbSpan.setName("SELECT * FROM customer");
		ResultSet rs = dbconnect.queryDB("SELECT * FROM customer");
		dbSpan.end();
		System.out.println("---> ending S#DBQuery");

		Courier courier = null;
		List<Courier> couriers = new ArrayList<Courier>();

		System.out.println("---> starting S#prepare list");
		Span javaSpan = transaction.startSpan("app", "list", "process");
		javaSpan.setName("create courier list");

		try {
			while (rs.next()) {
				courier = new Courier();
				courier.setId(rs.getInt("id"));
				courier.setName(rs.getString("name"));
				courier.setState(rs.getString("state"));
				courier.setCountry(rs.getString("country"));
				couriers.add(courier);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			javaSpan.end();
			System.out.println("---> ending S#prepare list");
		}

		GenericEntity<List<Courier>> responseList = new GenericEntity<List<Courier>>(couriers) {
		};
		transaction.end();
		System.out.println("---> ending T#prepare getCouriers");

		return Response.ok(responseList).build();
	}*/
}
