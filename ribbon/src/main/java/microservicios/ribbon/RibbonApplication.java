package microservicios.ribbon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RibbonApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//		ILoadBalancer lb = new BaseLoadBalancer();
//		List<Server> servers = new ArrayList<Server>();
//	    servers.add(new Server("localhost", 8080));
//	    servers.add(new Server("localhost", 8081));
//	    lb.addServers(servers);
//	    for(int i=0; i<10; i++){
//	        Server s = lb.chooseServer(null);
//	        System.out.println(s);
//	    }


//	    BaseLoadBalancer blb = new BaseLoadBalancer();
//	    MyRule myRule = new MyRule();
//	    myRule.setLoadBalancer(blb);
//	    blb.setRule(myRule);
//	    List<Server> servers = new ArrayList<Server>();
//	    servers.add(new Server("localhost", 8080));
//	    servers.add(new Server("localhost", 8081));
//	    blb.setServersList(servers);
//	    for(int i=0; i<10; i++){
//	        Server s = blb.chooseServer(null);
//	        System.out.println(s);
//	    }

//	    ConfigurationManager.getConfigInstance().setProperty("my-client2.ribbon.listOfServers", "localhost:8080,localhost:8081");
//	    ConfigurationManager.getConfigInstance().setProperty("my-client2.ribbon.NFLoadBalancerRuleClassName", MyRule.class.getName());
//	    System.out.println("List of services:" + ConfigurationManager.getConfigInstance().getProperty("my-client.ribbon.listOfServers"));
//
//	    RestClient client = (RestClient) ClientFactory.getNamedClient("my-client");
//	    HttpRequest request = HttpRequest.newBuilder().uri(new URI("/producto/1")).build();
//	    for (int i = 0; i < 10; i++) {
//	        HttpResponse response = client.executeWithLoadBalancer(request);
//	        String json = response.getEntity(String.class);
//	        System.out.println(json);
//	    }
//
//	    System.out.println(client.getServerStats(new Server("localhost:8080")));
//	    System.out.println(client.getServerStats(new Server("localhost:8081")));
    }
}

