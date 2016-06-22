package pl.surecase.eu;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyDaoGenerator {
    public static void main(String args[]) throws Exception {
     Schema schema = new Schema( 1, "com.xxx.bean");
     // 1: ��ݿ�汾��
    // com.xxx.bean:�Զ���ɵ�Bean�����ŵ�/java-gen/com/xxx/bean��

    schema.setDefaultJavaPackageDao("com.xxx.dao");
    // DaoMaster.java��DaoSession.java��BeanDao.java��ŵ�/java-gen/com/xxx/dao��

    // �����������ļ���·���������Զ��壬Ҳ���Բ�����

    initUserBean(schema); // ��ʼ��Bean��

    new DaoGenerator().generateAll(schema, "/Users/za205/Desktop/androidZHBIT/Diary3/app/src/main/java-gen");// �Զ�����
}

    private static void initUserBean(Schema schema) {
        Entity note = schema.addEntity("Note");// ����

        note.addIdProperty();

        note.addStringProperty("title").notNull();
        note.addStringProperty("body");
        note.addStringProperty("date");
    }
}

