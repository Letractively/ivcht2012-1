package edu.sstu.ivcht.term2012.util;

import edu.sstu.ivcht.term2012.service.AutoBaseService;
import edu.sstu.ivcht.term2012.service.AutoService;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 28.11.12
 * Time: 12:15
 * To change this template use File | Settings | File Templates.
 */
public class ServiceInstancer {
    public static AutoService getAutoService(){
        return AutoBaseService.getInstance();
    }


}
