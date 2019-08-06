package com.ibx.cac2web.sensitiveaccounts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/sensitiveaccounts")
public class SensitiveAccountsController {

    @Autowired
    private ISensitiveAccountsService sensitiveAccountsService;


    private static final String INDEX = "sensitiveaccounts";
    private static final String REDIRECTINDEX = "redirect:/sensitiveaccounts";

     public SensitiveAccountsController(ISensitiveAccountsService sensitiveAccountsService) {
        this.sensitiveAccountsService = sensitiveAccountsService;
    }

    @RequestMapping("rest/{id}")
    @ResponseBody()
       public SensitiveAccount getSensitiveAccountsById() {

        return null;// SensitiveAccountsDAO.getAccountsByID(id);
    }

    @GetMapping
    public ModelAndView getSensitiveAccounts(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int pageSize,
        @RequestParam(value = "searchText", required = false, defaultValue = "") String searchtext) {
        ModelAndView modelAndView = new ModelAndView(INDEX);
        modelAndView.addObject("searchText", searchtext);

        List<SensitiveAccount> sensitiveAccountsList;
        boolean allParametersSet = (!searchtext.isEmpty());

        if (allParametersSet) {
            sensitiveAccountsList = sensitiveAccountsService.getAccountsByMemberId(searchtext);
        } else {
            sensitiveAccountsList = sensitiveAccountsService.getMemberDataFromMADSensitiveAccount();
        }
        pagination(sensitiveAccountsList, modelAndView, page, pageSize);
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView addSensitiveAccount(@RequestParam String memberId, @RequestParam String firstName, @RequestParam String dateOfBirth, @RequestParam String comments){
         ModelAndView modelAndView = new ModelAndView(INDEX);
        if (memberId != null && firstName != null && dateOfBirth != null && comments != null) {
            sensitiveAccountsService.addSensitiveAccounts(memberId, firstName, dateOfBirth, comments);
            modelAndView.addObject("warning", "SensitiveAccountEntity added to the Database");
        } else {
            modelAndView.addObject("danger", "Something went wrong");
        }
                return new ModelAndView(REDIRECTINDEX);
    }

    @PostMapping(value = "/update")
    public ModelAndView updateSensitiveAccount(){

        return new ModelAndView(REDIRECTINDEX);
    }

    @RequestMapping(value = "/delete")
    public ModelAndView deleteSensitiveAccount(@RequestParam("deleteIDNumber") String id){
        String[] idParts = id.split("\\|");
        System.out.println(id);
        for(String p: idParts) {
            System.out.println(p);
        }
        sensitiveAccountsService.deleteSensitiveAccount(idParts[0], idParts[1], idParts[2]);
        return new ModelAndView(REDIRECTINDEX);
    }

    private void pagination(List<SensitiveAccount> sensitiveAccountsList, ModelAndView modelAndView, int page, int pageSize) {
        int numberOfPages = Math.max((sensitiveAccountsList.size() / pageSize), 1);
        int startIndex = (numberOfPages >= page) ? (page - 1) * pageSize : 1;
        int endIndex = (page == numberOfPages) ? sensitiveAccountsList.size() : startIndex + pageSize;
        modelAndView.addObject("numberOfPages", numberOfPages);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("dataList", sensitiveAccountsList.subList(startIndex, endIndex));
    }

}//end class
