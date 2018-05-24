
package com.bca.projetoaprendizado.Controller;

import java.util.List;
import com.bca.projetoaprendizado.util.MyException;
import com.bca.projetoaprendizado.model.bo.PessoaBO;
import com.bca.projetoaprendizado.model.vo.PessoaVO;

/**
 *
 * @author bruno
 */
public class PessoaController {

    public PessoaController() {

    }

    public void send(PessoaVO p) throws MyException {
        //test
        new PessoaBO().save(p);

    }

    public List<PessoaVO> lista() throws MyException {
        return new PessoaBO().lista();

    }

    public List<PessoaVO> lista(String sSearch) throws MyException {
        return new PessoaBO().lista(sSearch);

    }

}
