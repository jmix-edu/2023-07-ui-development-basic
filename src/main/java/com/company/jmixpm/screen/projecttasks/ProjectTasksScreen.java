package com.company.jmixpm.screen.projecttasks;

import com.company.jmixpm.entity.Project;
import com.company.jmixpm.entity.Task;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("ProjectTasksScreen")
@UiDescriptor("project-tasks-screen.xml")
public class ProjectTasksScreen extends Screen {

    @Autowired
    private CollectionLoader<Task> tasksDl;

    public void setProject(Project project) {
        if (project != null) {
            tasksDl.setParameter("projectId", project.getId());
        } else {
            tasksDl.removeParameter("projectId");
        }

        tasksDl.load();
    }
}