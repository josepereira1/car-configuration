package business.comercial;


import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;


public class Pacote  implements Comparable<Pacote> {
	private String id;
	private String nome;
	private float preco;
	private float desconto;
	private Set<String> componentes;



	public Pacote() {
		this.id = "";
		this.nome = "";
		this.preco = 0f;
		this.desconto = 0f;
		this.componentes = new TreeSet<String>();
	}

	public Pacote(String id, String nome, float preco, float desconto, Set<String> componentes) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
		this.componentes = new TreeSet<String>(componentes);
	}


	 public Pacote(Pacote pacote){
        this.id = pacote.getId();
        this.nome = pacote.getNome();
        this.preco = pacote.getPreco();
        this.componentes = pacote.getComponentes();
        this.desconto = pacote.getDesconto();
    }


	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public String getId() {
		return this.id;
	}


    public String getNome() {
		return this.nome;
	}


	public float getPreco() {
		return this.preco;
	}


	public Set<String> getComponentes(){
        return new TreeSet<String>(this.componentes);
    }


	public void setId(String id){
		this.id = id;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}


    public void setComponentes(Set<String> componentes){
        this.componentes = new TreeSet<String>(componentes);
    }
    

    public boolean equals(Object p){
        if(p == null) return false;
        if(this != p || this.getClass() != p.getClass())return false;

        Pacote pacote = (Pacote) p;
        return (this.id).equals(pacote.getId())
				&& (this.nome).equals(pacote.getNome())
				&& (this.preco) == pacote.getPreco()
				&& this.desconto == pacote.getDesconto()
				&& this.componentes.equals(pacote.getComponentes());
    }

    public Pacote clone() {
		return new Pacote(this);
	}

    public String toString(){
        StringBuilder sb = new StringBuilder("Pacote={");
        sb.append("id=").append(this.id);
        sb.append("; nome=").append(this.nome);
        sb.append("; preco=").append(this.preco);
        sb.append("; desconto=").append(this.desconto);
        Iterator<String> strings = componentes.iterator();
        sb.append("; idsComponentes= ");
		while (strings.hasNext()){
			String it = strings.next();
			sb.append(it);
			sb.append(",");
		}
		sb.deleteCharAt((sb.length() - 1));
        sb.append("}");
        return sb.toString();
    }


    public int compareTo(Pacote p) {
    	if (this.preco> p.preco) {
    		return 1;

    	}
        else {
        	if (this.preco < p.preco) {
        		return -1;
        	}
        	else {return 0;}
        }
    }

}
