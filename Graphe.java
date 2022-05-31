package gf;


import static java.lang.Math.exp;
import java.util.*;


public class Graphe {
	public static double profit=0;

	//structure represent arc avec sommet  soure et sommet destination et le poid d'arc
	static class arc {
		int src, dest;double poid;
	}

	
	static class Graph {

	
		int V, E;

		// graph representer comme tableau des arc.
		arc arc[];

	}

	// creation de graph 
	static Graph createGraph(int V, int E) {
		Graph graph = new Graph();
		graph.V = V;// nombre des sommets
		graph.E = E;// nombre des arcs
		graph.arc = new arc[graph.E];

		for (int i = 0; i < graph.E; i++) {
			graph.arc[i] = new arc();
		}

		return graph;
	}

	// fonction cherche le plus court shemin de source vers tous les sommmets utilisant algorithm belman-ford qui aussi detect circuit absorbant
	
	
	static boolean isNegCycleBellmanFord(Graph graph, int src) {
		int V = graph.V;
		int E = graph.E;
		double[] dist = new double[V];
                 double gg=0;
		Graph g = createGraph(V, E);

		//initialisation distance source vers tous les sommet par infinité
		for (int i = 0; i < V; i++)
			dist[i] = Double.MAX_VALUE;
		dist[src] = 0;

		
           //calcul de la distance     
		for (int i = 1; i <= V - 1; i++) {
			for (int j = 0; j < E; j++) {
				int u = graph.arc[j].src;
				int v = graph.arc[j].dest;
				double poid = graph.arc[j].poid;
				if (dist[u] != Double.MAX_VALUE && dist[u] + poid < dist[v])
                                {	dist[v] = dist[u] + poid;
                                 //gg=dist[u];
                               }
			}
                        
                         
		}

		//cherche circuit absorbant
               
		for (int i = 0; i < E; i++) {
			int u = graph.arc[i].src;
			int v = graph.arc[i].dest;
			double poid = graph.arc[i].poid;
                                               
			if (dist[u] != Double.MAX_VALUE && dist[u] + poid < dist[v])
				
                        {gg=dist[v];
				profit=exp(gg)-1;
                        
                        
                        
				return true;}
		}

		return false;
	
        
        
        }

	
	public static void main(String[] args) {
		int V = 5, E = 20;
                
		Graph graph = createGraph(V, E);
		//vous pouver utilisez ce code qui est dans le commentaire et mettre le 2em code de  partie //remplissage de graphe de l'utilisateur dans commentaire 
		// remplissage de graph
/*
                // add arc USD-EURO 
		graph.arc[0].src = 0;
		graph.arc[0].dest = 1;
		graph.arc[0].poid = -Math.log(0.741);
              

		// add arc USD-GBP 
		graph.arc[1].src = 0;
		graph.arc[1].dest = 2;
		graph.arc[1].poid = -Math.log(0.657);
                

		// add arc USD-CHF 
		graph.arc[2].src = 0;
		graph.arc[2].dest = 3;
		graph.arc[2].poid = -Math.log(1.061);
               

		// add arc USD-CAD
		graph.arc[3].src = 0;
		graph.arc[3].dest = 4;
		graph.arc[3].poid =-Math.log(1.005) ;
                

		// add arc EURO-USD
		graph.arc[4].src = 1;
		graph.arc[4].dest = 0;
		graph.arc[4].poid = -Math.log(1.349) ;
               

		// add arc EURO-GBP
		graph.arc[5].src = 1;
		graph.arc[5].dest = 2;
		graph.arc[5].poid = -Math.log(0.888);
                

		// add arc EURO-CHF
		graph.arc[6].src = 1;
		graph.arc[6].dest = 3;
		graph.arc[6].poid = -Math.log(1.433);
                

		// add arc EURO-CAD
		graph.arc[7].src = 1;
		graph.arc[7].dest = 4;
		graph.arc[7].poid = -Math.log(1.366);
               
                
                // add arc GPB-USD
		graph.arc[8].src = 2;
		graph.arc[8].dest = 0;
		graph.arc[8].poid = -Math.log(1.521);
                
                // add arc GBP-EURO
		graph.arc[9].src = 2;
		graph.arc[9].dest = 1;
		graph.arc[9].poid = -Math.log(1.126);
                // add arc GBP-CHF
		graph.arc[10].src = 2;
		graph.arc[10].dest = 3;
		graph.arc[10].poid = -Math.log(1.614);
                // add arc GBP-CAD
		graph.arc[11].src = 2;
		graph.arc[11].dest = 4;
		graph.arc[11].poid = -Math.log(1.538);
                // add arc CHF-USD
		graph.arc[12].src = 3;
		graph.arc[12].dest = 0;
		graph.arc[12].poid = -Math.log(0.942);
                // add arc CHF-EURO
		graph.arc[13].src = 3;
		graph.arc[13].dest = 1;
		graph.arc[13].poid = -Math.log(0.698);
                // add arc CHF-GBP
		graph.arc[14].src = 3;
		graph.arc[14].dest = 2;
		graph.arc[14].poid = -Math.log(0.619);
                // add arc CHF-CAD
		graph.arc[15].src = 3;
		graph.arc[15].dest = 4;
		graph.arc[15].poid = -Math.log(0.953);
                   // add arc CAD-USD
		graph.arc[16].src = 4;
		graph.arc[16].dest = 0;
		graph.arc[16].poid = -Math.log(0.995);
                   // add arc CAD-EURO
		graph.arc[17].src = 4;
		graph.arc[17].dest = 1;
		graph.arc[17].poid = -Math.log(0.732);
                   // add arc CAD-GBP
		graph.arc[18].src = 4;
		graph.arc[18].dest = 2;
		graph.arc[18].poid = -Math.log(0.650);
                   // add arc CAD-CHF
		graph.arc[19].src = 4;
		graph.arc[19].dest = 3;
		graph.arc[19].poid = -Math.log(1.049); */
      
		
		
		
	//remplissage de graphe de l'utilisateur 	 
for(int i=0; i<20;i++){
    int src,dst;double w;
    
	System.out.print("(usd=0   euro=1  GBP=3  CHF=4   CAD=5 ) donner sommet source : ");	 
    
             Scanner obj=new Scanner(System.in);  
		  
		 src=obj.nextInt();
                 
                 graph.arc[i].src = src;
                 System.out.print("(usd=0   euro=1  GBP=3  CHF=4   CAD=5 ) donner sommet destination : ");
                  Scanner objj=new Scanner(System.in);  
		  
		 dst=objj.nextInt();
		graph.arc[i].dest = dst;
                System.out.print(" donner poid d'arc : "); 
                Scanner o=new Scanner(System.in);  
		 
		 w=o.nextDouble();
				
		graph.arc[i].poid = -Math.log(w);
}




                
                for(int i=0; i<20; i++)
                {
                    String a="USD",b="EURO",c="GBP",d="CHF",e="CAD";
                  
                    if(graph.arc[i].src == 0)
                    {
                        if(graph.arc[i].dest == 1){
                       System.out.println(a+"-->"+b+"("+graph.arc[i].poid+")");}
                        else  if(graph.arc[i].dest == 2){
                       System.out.println(a+"-->"+c+"("+graph.arc[i].poid+")");}
                        else  if(graph.arc[i].dest == 3){
                       System.out.println(a+"-->"+d+"("+graph.arc[i].poid+")");}
                        else  if(graph.arc[i].dest == 4){
                       System.out.println(a+"-->"+e+"("+graph.arc[i].poid+")");}
                    }
                    
                      if(graph.arc[i].src == 1)
                    {
                        if(graph.arc[i].dest == 0){
                       System.out.println(b+"-->"+a+"("+graph.arc[i].poid+")");}
                        else  if(graph.arc[i].dest == 2){
                       System.out.println(b+"-->"+c+"("+graph.arc[i].poid+")");}
                        else  if(graph.arc[i].dest == 3){
                       System.out.println(b+"-->"+d+"("+graph.arc[i].poid+")");}
                        else  if(graph.arc[i].dest == 4){
                       System.out.println(b+"-->"+e+"("+graph.arc[i].poid+")");}
                    }
                        if(graph.arc[i].src == 2)
                    {
                        if(graph.arc[i].dest == 1){
                       System.out.println(c+"-->"+b+"("+graph.arc[i].poid+")");}
                        else  if(graph.arc[i].dest == 0){
                       System.out.println(c+"-->"+a+"("+graph.arc[i].poid+")");}
                        else  if(graph.arc[i].dest == 3){
                       System.out.println(c+"-->"+d+"("+graph.arc[i].poid+")");}
                        else  if(graph.arc[i].dest == 4){
                       System.out.println(c+"-->"+e+"("+graph.arc[i].poid+")");}
                    }
                          if(graph.arc[i].src == 0)
                    {
                        if(graph.arc[i].dest == 3){
                       System.out.println(d+"-->"+b+"("+graph.arc[i].poid+")");}
                        else  if(graph.arc[i].dest == 2){
                       System.out.println(d+"-->"+c+"("+graph.arc[i].poid+")");}
                        else  if(graph.arc[i].dest == 0){
                       System.out.println(d+"-->"+a+"("+graph.arc[i].poid+")");}
                        else  if(graph.arc[i].dest == 4){
                       System.out.println(d+"-->"+e+"("+graph.arc[i].poid+")");}
                    }
                            if(graph.arc[i].src == 4)
                    {
                        if(graph.arc[i].dest == 1){
                       System.out.println(e+"-->"+b+"("+graph.arc[i].poid+")");}
                        else  if(graph.arc[i].dest == 2){
                       System.out.println(e+"-->"+c+"("+graph.arc[i].poid+")");}
                        else  if(graph.arc[i].dest == 3){
                       System.out.println(e+"-->"+d+"("+graph.arc[i].poid+")");}
                        else  if(graph.arc[i].dest == 0){
                       System.out.println(e+"-->"+a+"("+graph.arc[i].poid+")");}
                    }
                }

		if (isNegCycleBellmanFord(graph, 0)) {
			System.out.println("il y a circuit absorbant");
			System.out.println("profit  "+profit);}
		
		else
			System.out.println("il y a pas circuit absorbant");
	}
        
        
        
}

