/*
 * Projeto de redes de Computadores turma 2018.1.
 * Diciplina POO Java.
 * Professor Francisco Petrônio.
 * Classe de Pessoa física
 */
package classe;

import java.io.Serializable;
import java.util.Objects;
/**
 * @author Joselito Muniz
 * @author Lucas Fernandes
 * @author Julio Cezar 
 */
public class Fisica extends Pessoa implements Serializable{    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;  

	/**
	 * Contrutor
	 * @param cpf
	 * @param nome
	 * @param endereco
	 * @param email
	 * @param telefone
	 * @param usuario
	 * @param senha
	 */
    public Fisica(String cpf, String nome, Endereco endereco, String email, String telefone, String usuario, String senha) {
        super(nome, endereco, email, telefone, usuario, senha);
        this.cpf = cpf;
    }

    /**
     * gets and sets
     * @return
     */
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * hashcode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    /**
     *equals
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fisica other = (Fisica) obj;
        return Objects.equals(this.cpf, other.cpf);
    }

    @Override
    public String toString() {
        return "Username: " + this.getUsuario() + " CPF: " + this.cpf;
    }    
    
}
