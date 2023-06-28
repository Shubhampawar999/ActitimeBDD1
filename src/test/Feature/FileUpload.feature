Feature:File Upload

  @FileUpload
  Scenario:File Upload
    Given I prepare request Structure to upload file
    Then I verify file is uploaded successfully
