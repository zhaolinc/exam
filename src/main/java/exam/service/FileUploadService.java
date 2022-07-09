package exam.service;

import exam.domain.Proplem;

import java.io.InputStream;
import java.util.List;

public interface FileUploadService {
    public List<Proplem> proplemList(InputStream inputStream);
}
