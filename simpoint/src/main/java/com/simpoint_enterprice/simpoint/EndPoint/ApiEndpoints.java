package com.simpoint_enterprice.simpoint.EndPoint;

public final class ApiEndpoints {
    private ApiEndpoints() {}

    // ===== CATEGORY =====
    public static final String CATEGORY = "/category";
    public static final String CATEGORY_ID = "/{id}";

    // ===== SUB CATEGORY =====
    public static final String SUBCATEGORY = "/subcategory";
    public static final String SUBCATEGORY_ID = "/{id}";

    // ===== COURSE =====
    public static final String COURSE = "/course";
    public static final String COURSE_ID = "/{id}";

    // ===== MODULE =====
    public static final String MODULE = "/module";
    public static final String MODULE_ID = "/{id}";

    // ===== MODULE CONTENT =====
    public static final String MODULE_CONTENT = "/moduleContent";
    public static final String MODULE_CONTENT_ID = "/{id}";

    // ===== LESSON =====
    public static final String LESSON = "/lesson";
    public static final String LESSON_ID = "/{id}";

    // ===== ASSESSMENT =====
    public static final String ASSESSMENT = "/assessment";
    public static final String ASSESSMENT_ID = "/{id}";

    // ===== QUESTION =====
    public static final String QUESTION = "/question";
    public static final String QUESTION_ID = "/{id}";

    // ===== ASSESSMENT ↔ QUESTION LINK =====
    public static final String ASSESSMENT_QUESTION = "/questionLinktoAssessment";
    public static final String ASSESSMENT_QUESTION_BY_ASSESSMENT =
            "/{assessmentId}/questions";

    // ===== TOPIC =====
    public static final String TOPIC = "/topic";
    public static final String TOPIC_ID = "/{id}";

    // ===== EDITOR =====
    public static final String EDITOR = "/editor";
    public static final String EDITOR_ID = "/{id}";



}
