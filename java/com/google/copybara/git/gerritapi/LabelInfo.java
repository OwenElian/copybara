/*
 * Copyright (C) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.copybara.git.gerritapi;

import com.google.api.client.util.Key;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.devtools.build.lib.skylarkinterface.SkylarkCallable;
import com.google.devtools.build.lib.skylarkinterface.SkylarkModule;
import com.google.devtools.build.lib.skylarkinterface.SkylarkModuleCategory;
import com.google.devtools.build.lib.skylarkinterface.SkylarkPrinter;
import com.google.devtools.build.lib.skylarkinterface.SkylarkValue;
import java.util.List;
import java.util.Map;

/** https://gerrit-review.googlesource.com/Documentation/rest-api-changes.html#label-info */
@SuppressWarnings("unused")
@SkylarkModule(
    name = "gerritapi.LabelInfo",
    category = SkylarkModuleCategory.TOP_LEVEL_TYPE,
    doc = "Gerrit label information.")
public class LabelInfo implements SkylarkValue {
  @Key boolean optional;
  @Key AccountInfo approved;
  @Key AccountInfo rejected;
  @Key AccountInfo recommended;
  @Key AccountInfo disliked;
  @Key boolean blocking;
  @Key int value;
  @Key("default_value") int defaultValue;
  @Key Map<String, String> values;
  @Key List<ApprovalInfo> all;

  public boolean isOptional() {
    return optional;
  }

  @SkylarkCallable(
      name = "approved",
      doc =
          "One user who approved this label on the change (voted the maximum value) as an "
              + "AccountInfo entity.",
      structField = true,
      allowReturnNones = true)
  public AccountInfo getApproved() {
    return approved;
  }

  @SkylarkCallable(
      name = "rejected",
      doc =
          "One user who rejected this label on the change (voted the minimum value) as an "
              + "AccountInfo entity.",
      structField = true,
      allowReturnNones = true)
  public AccountInfo getRejected() {
    return rejected;
  }

  @SkylarkCallable(
      name = "recommended",
      doc =
          "One user who recommended this label on the change (voted positively, but not the "
              + "maximum value) as an AccountInfo entity.",
      structField = true,
      allowReturnNones = true)
  public AccountInfo getRecommended() {
    return recommended;
  }

  @SkylarkCallable(
      name = "disliked",
      doc =
          "One user who disliked this label on the change (voted negatively, but not the "
              + "minimum value) as an AccountInfo entity.",
      structField = true,
      allowReturnNones = true)
  public AccountInfo getDisliked() {
    return disliked;
  }

  @SkylarkCallable(
      name = "blocking",
      doc = "If true, the label blocks submit operation. If not set, the default is false.",
      structField = true,
      allowReturnNones = true)
  public boolean isBlocking() {
    return blocking;
  }

  @SkylarkCallable(
      name = "value",
      doc =
          "The voting value of the user who recommended/disliked this label on the change if "
              + "it is not “+1”/“-1”.",
      structField = true,
      allowReturnNones = true)
  public int getValue() {
    return value;
  }

  @SkylarkCallable(
      name = "default_value",
      doc =
          "The default voting value for the label. This value may be outside the range "
              + "specified in permitted_labels.",
      structField = true,
      allowReturnNones = true)
  public int getDefaultValue() {
    return defaultValue;
  }

  @SkylarkCallable(
      name = "values",
      doc =
          "A map of all values that are allowed for this label. The map maps the values "
              + "(“-2”, “-1”, \" `0`\", “+1”, “+2”) to the value descriptions.",
      structField = true,
      allowReturnNones = true)
  public ImmutableMap<String, String> getValues() {
    return ImmutableMap.copyOf(values);
  }

  @SkylarkCallable(
      name = "all",
      doc =
          "List of all approvals for this label as a list of ApprovalInfo entities. Items "
              + "in this list may not represent actual votes cast by users; if a user votes on "
              + "any label, a corresponding ApprovalInfo will appear in this list for all labels.",
      structField = true,
      allowReturnNones = true)
  public ImmutableList<ApprovalInfo> getAll() {
    return all != null ? ImmutableList.copyOf(all) : ImmutableList.of();
  }

  @Override
  public void repr(SkylarkPrinter printer) {
    printer.append(toString());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("optional", optional)
        .add("approved", approved)
        .add("rejected", rejected)
        .add("recommended", recommended)
        .add("disliked", disliked)
        .add("blocking", blocking)
        .add("value", value)
        .add("defaultValue", defaultValue)
        .add("values", values)
        .add("all", all)
        .toString();
  }
}
