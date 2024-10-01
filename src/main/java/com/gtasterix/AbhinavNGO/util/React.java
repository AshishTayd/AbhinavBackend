package com.gtasterix.AbhinavNGO.util;

import com.gtasterix.AbhinavNGO.model.User;
import lombok.Data;


    @Data
    public class React {
        private String message;
        private Object object; // Correct type
         private boolean hasError; // Correct type

        public React(String message, Object object, boolean hasError)
        {
            this.message = message;
            this.object = object;
          this.hasError = hasError;
        }
    }

