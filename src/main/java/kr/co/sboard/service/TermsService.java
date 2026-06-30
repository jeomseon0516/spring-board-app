package kr.co.sboard.service;

import kr.co.sboard.dao.TermsDAO;
import kr.co.sboard.dto.TermsDTO;
import kr.co.sboard.repository.TermsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class TermsService {

    private final TermsDAO dao;
    private final TermsRepository repository;

    public TermsDTO get(int no){
        return dao.select(no);
    }
    public List<TermsDTO> getAll(){
        return null;
    }
    public void register(TermsDTO dto){

    }
    public void modify(TermsDTO dto){

    }
    public void remove(int no){

    }
}