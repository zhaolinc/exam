package exam.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import exam.domain.Proplem;
import exam.service.FileUploadService;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Override
    public List<Proplem> proplemList(InputStream inputStream) {
        List<Proplem> list = new ArrayList<>();
        EasyExcel.read(inputStream)
                .head(Proplem.class)
                .sheet()
                .registerReadListener(new AnalysisEventListener<Proplem>() {
                    @Override
                    public void invoke(Proplem proplem, AnalysisContext analysisContext) {
                        proplem.setId(UUID.randomUUID().toString());
                        Date date = new Date();
                        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String dateStr=sdf.format(date);
                        proplem.setCreatetime(dateStr);
                        list.add(proplem);
                    }

                    @Override
                    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

                    }
                }).doRead();
        return list;
    }
}
