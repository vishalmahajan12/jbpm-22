{"id":"64f4ff96-78eb-4314-8e17-95f31f88c962","name":"ApprovalTask-taskform.frm","model":{"taskName":"ApprovalTask","processId":"src.Workflow2","properties":[{"name":"groupName","typeInfo":{"type":"BASE","className":"java.lang.String","multiple":false},"metaData":{"entries":[]}},{"name":"transaction","typeInfo":{"type":"OBJECT","className":"com.myspace.cib_phase2.modal.Transaction","multiple":false},"metaData":{"entries":[]}}],"formModelType":"org.kie.workbench.common.forms.jbpm.model.authoring.task.TaskFormModel"},"fields":[{"maxLength":100,"placeHolder":"GroupName","id":"field_83082908326054E11","name":"groupName","label":"GroupName","required":false,"readOnly":false,"validateOnChange":true,"binding":"groupName","standaloneClassName":"java.lang.String","code":"TextBox","serializedFieldClassName":"org.kie.workbench.common.forms.fields.shared.fieldTypes.basic.textBox.definition.TextBoxFieldDefinition"},{"nestedForm":"b8a95d73-687e-47c3-b99c-014254aa8a1d","container":"FIELD_SET","id":"field_5340329848476309E12","name":"transaction","label":"Transaction","required":false,"readOnly":false,"validateOnChange":true,"binding":"transaction","standaloneClassName":"com.myspace.cib_phase2.modal.Transaction","code":"SubForm","serializedFieldClassName":"org.kie.workbench.common.forms.fields.shared.fieldTypes.relations.subForm.definition.SubFormFieldDefinition"}],"layoutTemplate":{"version":3,"style":"FLUID","layoutProperties":{},"rows":[{"properties":{},"layoutColumns":[{"span":"12","height":"12","properties":{},"rows":[],"layoutComponents":[{"dragTypeName":"org.uberfire.ext.plugin.client.perspective.editor.layout.editor.HTMLLayoutDragComponent","properties":{"HTML_CODE":"\u003ch3\u003eOutputs:\u003c/h3\u003e"},"parts":[]}]}]},{"properties":{},"layoutColumns":[{"span":"12","height":"12","properties":{},"rows":[],"layoutComponents":[{"dragTypeName":"org.kie.workbench.common.forms.editor.client.editor.rendering.EditorFieldLayoutComponent","properties":{"field_id":"field_83082908326054E11","form_id":"64f4ff96-78eb-4314-8e17-95f31f88c962"},"parts":[]}]}]},{"properties":{},"layoutColumns":[{"span":"12","height":"12","properties":{},"rows":[],"layoutComponents":[{"dragTypeName":"org.kie.workbench.common.forms.editor.client.editor.rendering.EditorFieldLayoutComponent","properties":{"field_id":"field_5340329848476309E12","form_id":"64f4ff96-78eb-4314-8e17-95f31f88c962"},"parts":[]}]}]}]}}